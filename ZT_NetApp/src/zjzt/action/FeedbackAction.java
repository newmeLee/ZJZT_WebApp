package zjzt.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import zjzt.entity.Feedback;
import zjzt.service.IFeedbackService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FeedbackAction extends ActionSupport {
	private int id;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String message;
	private String result;
	private Feedback feedback;
	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private IFeedbackService feedbackService;

	public void setFeedbackService(IFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	/**
	 * 增加一条反馈信息
	 * @return
	 */
	public String addFeedback() {
		Feedback feedback = new Feedback();
		feedback.setUserName(userName);
		feedback.setUserEmail(userEmail);
		feedback.setUserPhone(userPhone);
		feedback.setMessage(message);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		feedback.setGmtCreate(format.format(new Date()));
		if (feedbackService.addFeedback(feedback)) {
			setResult("success");
		} else {
			setResult("error");
		}
		return "success";
	}
	/**
	 * 获取所有的反馈信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAllFeedback(){
		List<Feedback> feedbacks=feedbackService.getAllFeedback();
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		//System.out.println("数目"+feedbacks.size());
		request.put("feedbackList", feedbacks);
		return SUCCESS;
	}
	/**
	 * 根据ID获取反馈信息
	 * @return
	 */
	public String getFeedbackById(){
		if(getId()>0){
			this.setFeedback(feedbackService.getFeedbackById(id));
		}
		return SUCCESS;
	}
}
