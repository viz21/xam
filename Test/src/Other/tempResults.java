package Other;

import javax.swing.JRadioButton;

public class tempResults {

	String QuestionID = null;
	String QuestionNumber = null;
	String Question = null;
	JRadioButton CorrectAnswer = null;
	JRadioButton AAnswer1 = null;
	JRadioButton AAnswer2 = null;
	JRadioButton AAnswer3 = null;
	
	public tempResults(String QuestionID, String QuestionNumber, String Question, JRadioButton CorrectAnswer, JRadioButton AAnswer1, JRadioButton AAnswer2, JRadioButton AAnswer3) {
		this.QuestionID = QuestionID;
		this.QuestionNumber = QuestionNumber;
		this.Question = Question;
		this.CorrectAnswer = CorrectAnswer;
		this.AAnswer1 = AAnswer1;
		this.AAnswer2 = AAnswer2;
		this.AAnswer3 = AAnswer3;
	}
}
