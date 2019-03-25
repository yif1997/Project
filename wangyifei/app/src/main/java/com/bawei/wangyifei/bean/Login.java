package com.bawei.wangyifei.bean;

/**
 * @author 王艺霏
 * @fileName Login
 * @package com.bawei.wangyifei.bean
 **/
public class Login {
    public String headPic;
    public String nickName;
    public String sessionId;
    public String userId;

    public Login(String headPic, String nickName, String sessionId, String userId) {
        this.headPic = headPic;
        this.nickName = nickName;
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Login{" +
                "headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
