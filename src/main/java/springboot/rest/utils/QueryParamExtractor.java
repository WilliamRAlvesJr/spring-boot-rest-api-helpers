package springboot.rest.utils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import springboot.rest.entities.QueryParamWrapper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class QueryParamExtractor {
    
    public static QueryParamWrapper extract(BaseFilterDTO dto) {
        JSONObject jsonDTO = dtoToJson(dto);

        String filterStr = "";
        String sortStr = "";
        String rangeStr = "";

        try {
            filterStr = jsonDTO.get("filter").toString();
        } catch (JSONException e) {}

        try {
            rangeStr = jsonDTO.getString("range");
        } catch (JSONException e) {}

        try {
            sortStr = jsonDTO.getString("sort");
        } catch (JSONException e) {}

        rangeStr = "[".concat(rangeStr).concat("]");
        sortStr  = "[".concat(sortStr).concat("]");

        return extract(filterStr, rangeStr, sortStr);
    }

    public static QueryParamWrapper extract(String filterStr, String rangeStr, String sortStr) {



        Object filterJsonOrArray;
        if (StringUtils.isBlank(filterStr)) {
            filterStr = "{}";
        }

        //https://stackoverflow.com/a/18368345
        filterStr = filterStr.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        filterStr = filterStr.replaceAll("\\+", "%2B");
        try {
            //https://stackoverflow.com/a/6926987/986160
            filterStr = URLDecoder.decode(filterStr.replace("+", "%2B"), "UTF-8")
                    .replace("%2B", "+");
        } catch (UnsupportedEncodingException e) {
        }

        filterJsonOrArray = new JSONTokener(filterStr).nextValue();
        JSONObject filter = null;
        JSONArray filterOr = null;
        if (filterJsonOrArray instanceof JSONObject) {
            filter = JSON.toJsonObject(filterStr);
        }
        else if (filterJsonOrArray instanceof JSONArray){
            filterOr = JSON.toJsonArray(filterStr);
        }
        JSONArray range;
        if (StringUtils.isBlank(rangeStr)) {
            rangeStr = "[]";
        }
        range = JSON.toJsonArray(rangeStr);

        JSONArray sort;
        if (StringUtils.isBlank(sortStr)) {
            sortStr = "[]";
        }
        sort = JSON.toJsonArray(sortStr);


        return new QueryParamWrapper(filter, filterOr, range, sort);
    }
}
