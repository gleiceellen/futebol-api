import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Player(
        @Id
        @Column(name = "id", nullable = false)
        var id: Long? = null,
        val name: String,
        val birthDate: String,
        val country: String,
        @OneToMany
        val club: Club
)