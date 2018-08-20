package com.gtjh.user.bean;

/**
 * Created by android on 2018/7/16.
 */

public class ForgetBean {
    public InitBean initBean;
    public TokenBean sendBean;
    public static class InitBean{

        /**
         *  // 是否需要验证码
         * forgotCaptchaActive : true
         */

        private boolean forgotCaptchaActive;

        public boolean isForgotCaptchaActive() {
            return forgotCaptchaActive;
        }

        public void setForgotCaptchaActive(boolean forgotCaptchaActive) {
            this.forgotCaptchaActive = forgotCaptchaActive;
        }
    }
    public static  class TokenBean{


        /**
         * // 充值密码页面，验证token是否有效、
         * resetPasswordActive : true
         */

        private boolean resetPasswordActive;

        public boolean isResetPasswordActive() {
            return resetPasswordActive;
        }

        public void setResetPasswordActive(boolean resetPasswordActive) {
            this.resetPasswordActive = resetPasswordActive;
        }
    }
}
