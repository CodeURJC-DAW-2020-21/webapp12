package undersociety.models;

public class MessageModel {

    private String message;
    private String fromLogin;
<<<<<<< HEAD
=======
    private String time;
>>>>>>> SpringAppUserAndCompanyPage

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromLogin() {
        return fromLogin;
    }

    public void setFromLogin(String fromLogin) {
        this.fromLogin = fromLogin;
    }
<<<<<<< HEAD

    @Override
=======
    
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
>>>>>>> SpringAppUserAndCompanyPage
    public String toString() {
        return "MessageModel{" +
                "message='" + message + '\'' +
                ", fromLogin='" + fromLogin + '\'' +
<<<<<<< HEAD
=======
                ", time='" + time + '\'' +
>>>>>>> SpringAppUserAndCompanyPage
                '}';
    }
}
