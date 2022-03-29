import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Club(
        @Id
        @Column(name = "id", nullable = false)
        var id: Long? = null,
        val name: String,
        val location: String,
        val titles: String
)