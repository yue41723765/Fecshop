package com.gtjh.router_core.template;



import com.gtjh.router_annotation.model.RouteMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lance
 * @date 2018/2/22
 */

public interface IActivity {

    void loadInto(Map<String,Class> classList);
}
