package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "job_position")
@Data
public class JobPosition {

	@Id
	@Column(name = "position_id")
	private int positionId;

	@Column(name = "position_name ")
	private String positionName;

	@Column(name = "employer_id")
	private int employerId;

	public JobPosition() {

	}

	public JobPosition(int positionId, String positionName, int employerId) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.employerId = employerId;
	}

}
