import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20032405, 6 Aug 2021 9:27:03 am
 */

/**
 * @author 20032405
 *
 */
public class Quotation {

    private String RID;
    private String QID;
    private String RC;
    private String RD;
    private String DN;
    private String ESD;
    private String TQA;
    

    public Quotation(String RID, String QID, String RC, String RD, String DN, String ESD, String TQA) {
        this.RID = RID;
        this.QID = QID;
        this.RC = RC;
        this.RD = RD;
        this.DN = DN;
        this.ESD = ESD;
        this.TQA = TQA;
    }
    
    /**
	 * @return the rID
	 */
	public String getRID() {
		return RID;
	}



	/**
	 * @return the qID
	 */
	public String getQID() {
		return QID;
	}



	/**
	 * @return the rC
	 */
	public String getRC() {
		return RC;
	}



	/**
	 * @return the rD
	 */
	public String getRD() {
		return RD;
	}



	/**
	 * @return the dN
	 */
	public String getDN() {
		return DN;
	}



	/**
	 * @return the eSD
	 */
	public String getESD() {
		return ESD;
	}



	/**
	 * @return the tQA
	 */
	public String getTQA() {
		return TQA;
	}


	public String stringQuote() {
        return String.format("%-15s %-15s %-15s %-15s %-15s %-15s %s\n", getRID(), getQID(), getRC(), getRD(), getDN(), getESD(), getTQA());
    }

}
