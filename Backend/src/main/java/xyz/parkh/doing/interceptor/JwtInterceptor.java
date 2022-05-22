package xyz.parkh.doing.interceptor;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Log4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
        HashMap<String, Object> tokenMap;
        String jwtToken = request.getHeader("Authorization");

        if (jwtToken != null) {
            tokenMap = JwtManager.verifyToken(request.getHeader("Authorization"));

            if ("000".equals(tokenMap.get("tokenCode"))) {
                request.setAttribute("userId", tokenMap.get("userId"));
                return true;
            } else if ("901".equals(tokenMap.get("tokenCode"))) {
                response.sendError(401);
                return false;
            } else if ("902".equals(tokenMap.get("tokenCode"))) {
                response.sendError(401);
                return false;
            } else if ("903".equals(tokenMap.get("tokenCode"))) {
                response.sendError(401);
                return false;
            } else if ("999".equals(tokenMap.get("tokenCode"))) {
                response.sendError(400);
                return false;
            }
        }
        response.sendError(401);
        return false;
    }


    // TODO 이건 왜 구현 하신건지
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }


}
