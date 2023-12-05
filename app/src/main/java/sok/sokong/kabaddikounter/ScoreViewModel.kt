import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sok.sokong.kabaddikounter.Team

class ScoreViewModel : ViewModel() {
    private val _teamA = MutableLiveData<Team>()
    val teamA: LiveData<Team> = _teamA

    private val _teamB = MutableLiveData<Team>()
    val teamB: LiveData<Team> = _teamB

    init {
        _teamA.value = Team("Team A", 0)
        _teamB.value = Team("Team B", 0)
    }

    fun addScore(team: String, point: Int) {
        when (team) {
            "A" -> {
                val currentScore = _teamA.value?.score ?: 0
                _teamA.value = Team("Team A", currentScore + point)
            }
            "B" -> {
                val currentScore = _teamB.value?.score ?: 0
                _teamB.value = Team("Team B", currentScore + point)
            }
        }
    }

    fun resetScore() {
        _teamA.value = Team("Team A", 0)
        _teamB.value = Team("Team B", 0)
    }
}
