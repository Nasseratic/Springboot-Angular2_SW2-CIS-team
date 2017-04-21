package hello.gameService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Entity
public class Game {

	@Id
	private String id;
	@NotNull
	private String name;
	private String teacher;
	private String category;
	@OneToMany
	private ArrayList<Q> qs =new ArrayList<>();
	public Game() {
		
	}

	public Game(String id, String name, String teacher, String category) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<Q> getQs() {
		return qs;
	}

	public void addQ(Q q ) {

		this.qs.add(q);
	}

}
