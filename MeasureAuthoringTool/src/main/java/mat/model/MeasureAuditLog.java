package mat.model;

import mat.model.clause.Measure;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "MEASURE_AUDIT_LOG")
public class MeasureAuditLog {
	private String id;
	private String activityType;	
	private Timestamp time;
	private String userId;
	private Measure measure;
	private String additionalInfo;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP", nullable = false, length = 19)
	public Date getTime() {
		return (Date)time;
	}

	public void setTime(Date created) {
		this.time = new Timestamp(created.getTime());
	}

	@ManyToOne
	@JoinColumn(name="MEASURE_ID")
	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	@Column(name = "ACTIVITY_TYPE", nullable = false, length = 40)
	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}


	@Column(name = "USER_ID", nullable = false, length = 40)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Column(name = "ADDL_INFO", length = 2000)
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
