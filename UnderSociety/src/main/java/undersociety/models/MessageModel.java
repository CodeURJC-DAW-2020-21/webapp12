package undersociety.models;

public class MessageModel {

    private String message;
    private String fromLogin;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private String time;
>>>>>>> SpringAppUserAndCompanyPage
=======
    private String time;
>>>>>>> SpringAppIndexPage

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
<<<<<<< HEAD

    @Override
=======
=======
>>>>>>> SpringAppIndexPage
    
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
<<<<<<< HEAD
>>>>>>> SpringAppUserAndCompanyPage
=======
>>>>>>> SpringAppIndexPage
    public String toString() {
        return "MessageModel{" +
                "message='" + message + '\'' +
                ", fromLogin='" + fromLogin + '\'' +
<<<<<<< HEAD
<<<<<<< HEAD
=======
                ", time='" + time + '\'' +
>>>>>>> SpringAppUserAndCompanyPage
=======
                ", time='" + time + '\'' +
>>>>>>> SpringAppIndexPage
                '}';
    }
}
