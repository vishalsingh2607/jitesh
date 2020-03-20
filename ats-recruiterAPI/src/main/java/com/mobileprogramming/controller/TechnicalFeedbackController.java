package com.mobileprogramming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobileprogramming.model.TechnicalFeedback;
import com.mobileprogramming.response.Response;
import com.mobileprogramming.service.TechnicalFeedbackService;



@RestController
@RequestMapping("/technicalfeedback-api")
@CrossOrigin
public class TechnicalFeedbackController {
	
	@Autowired
	private TechnicalFeedbackService feedbackService;


	// Api for fetching HR feedback details
	/*
	 * @RequestMapping(value = "hrfeedbackapi/getallfeedback", method =
	 * RequestMethod.GET) public List<HRfeedbackDto> getHrFeedback() {
	 * 
	 * if (hrfeedbackService.getHrFeedback().isEmpty()) { throw new
	 * RuntimeException("No feedback data is avilable"); } else { return
	 * hrfeedbackService.getHrFeedback(); }
	 * 
	 * }
	 */

	// Api for adding HR feedback
	@RequestMapping(value = "/addfeedback/{id}", method = RequestMethod.POST)
	public Response<TechnicalFeedback> addHrFeedback(@RequestBody TechnicalFeedback feedback, @PathVariable Integer id) {
		
		Response<TechnicalFeedback> response=new Response<TechnicalFeedback>();
	/*	if (id != null) {
			//Optional<TechnicalFeedback> reOptional = feedbackService.getTechnicalFeedbackForCandidate(id);
			if (feedback.getComment()!=null&&feedback.getCommunicationRating()!=null&&feedback.getDepartment()!=null&&feedback.getInterviewDate()!=null&&
					feedback.getTechnicalInterviewer()!=null&&feedback.getTechnicalRating()!=null) {*/
		
		TechnicalFeedback tf=feedbackService.addTechnicalFeedback(feedback);
		tf.setId(null);
		response.setStatus(true);
		response.setMessage("Feedback Created Succesfully");
		response.setResponse(tf);
		
			
			/*} 
				 * else { response.setStatus(false); response.setMessage("Feedback Failed");
				 * return response; }
				 */
		

	//}
		return response;
	}
		

}
