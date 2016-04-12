package com.webapp.controller;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {
	
	@RequestMapping("/kakao_login.do")
	public String KakaoLogin(Model model) {
		
		//model.addAttribute("greeting", "Hello Spring MVC");
		
		return "kakao_login";
	}
	
	@RequestMapping("/oauth.do")
	public String OAuthLogin(Model model) {
		return "oauth";
	}
	
	@RequestMapping("/kakao_oauth.do")
	public String KakaoOauth(Model model,@RequestParam("code")String code) throws OAuthSystemException, OAuthProblemException {
		
		OAuthClientRequest req = OAuthClientRequest
				.tokenLocation("https://kauth.kakao.com/oauth/token")
				.setGrantType(GrantType.AUTHORIZATION_CODE)
				.setClientId("6d72ee8faec3e4c789251005dde9e8bb")
				.setRedirectURI("http://www.mjpcloud.net/kakao_oauth.do")
				.setCode(code)
				.buildQueryMessage();
				OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
				OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(req,
				OAuthJSONAccessTokenResponse.class);
				String accessToken = oAuthResponse.getAccessToken();
				
				model.addAttribute("accessToken", accessToken);
		
		return "kakao_oauth";
	}
	
	@RequestMapping("/user.do")
	public String getUserInfoFromKakao(Model model,@RequestParam("accessToken")String accessToken) throws OAuthSystemException, OAuthProblemException {
		
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
		OAuthClientRequest bearerClientRequest = new
				OAuthBearerClientRequest("https://kapi.kakao.com/v1/user/me")
				.setAccessToken(accessToken)
				.buildQueryMessage();
				bearerClientRequest.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
				OAuthResourceResponse resourceResponse =
				oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET,
				OAuthResourceResponse.class);
				String responseBody = resourceResponse.getBody();
				//JSONObject obj = new JSONObject(responseBody);
				//String nickname = obj.getString("properties.nickname");
				//String thumbnail = obj.getString("properties.thumbnail_image");
				System.out.println(responseBody);
				model.addAttribute("responseBody",responseBody);
				
		return "user";
	}
}
