package studenti;




import java.time.LocalDate;


public class studenti {

	private Long id;
	private String name;
	private String lastName;
	private String gender;
	private LocalDate birthdate;
	private Integer avg;
	private Integer min_vote;
	private Integer max_vote;

	@Override
	public String toString() {
		return "studenti [id=" + id + ", name=" + name + ", lastname=" + lastName + ", gender=" + gender
				+ ", birthdate=" + birthdate + ", avg=" + avg + ", min_vote=" + min_vote + ", max_vote=" + max_vote
				+ "]";
	}


	public studenti(String name, String lastname, String gender, String birthdate,Integer min_vote,Integer max_vote) {
		super();
		this.name = name;
		this.lastName = lastname;
		this.gender = gender;
		this.birthdate = LocalDate.parse(birthdate);
		this.min_vote = min_vote;
		this.max_vote = max_vote;
		this.avg = (min_vote + max_vote)/2;
	}

	
	public studenti(Long id, String name, String lastname, String gender, String birthdate, Integer avg, Integer min_vote,
			Integer max_vote) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastname;
		this.gender = gender;
		this.birthdate = LocalDate.parse(birthdate);;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
		this.avg = (min_vote + max_vote)/2;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastName;
	}


	public void setLastname(String lastname) {
		this.lastName = lastname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}


	public Integer getMin_vote() {
		return min_vote;
	}


	public void setMin_vote(Integer min_vote) {
		this.min_vote = min_vote;
	}


	public Integer getMax_vote() {
		return max_vote;
	}


	public void setMax_vote(Integer max_vote) {
		this.max_vote = max_vote;
	}
	
	
	public Integer getAvg() {
		return avg;
	}
}
