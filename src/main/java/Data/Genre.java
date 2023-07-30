package Data;

/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
public class Genre {
	private int id;
	private String name;

	public Genre() {
	}

	public Genre(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data.Genre other = (Data.Genre) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data.Genre [id=" + id + ", name=" + name + "]";
	}

}
