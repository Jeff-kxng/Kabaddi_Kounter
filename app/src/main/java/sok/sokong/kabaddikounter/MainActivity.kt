package sok.sokong.kabaddikounter

import ScoreViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import sok.sokong.kabaddikounter.databinding.ActivityMainBinding // Import your binding class

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Declare the binding variable
    private lateinit var viewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)

        viewModel.teamA.observe(this, { team ->
            binding.teamAScoreEditText.setText(team.score.toString())
        })

        viewModel.teamB.observe(this, { team ->
            binding.teamBScoreEditText.setText(team.score.toString())
        })

        binding.teamAPlusOneButton.setOnClickListener {
            viewModel.addScore("A", 1)
        }

        binding.teamAPlusTwoButton.setOnClickListener {
            viewModel.addScore("A", 2)
        }

        binding.teamAPlusThreeButton.setOnClickListener {
            viewModel.addScore("A", 3)
        }

        binding.teamBPlusOneButton.setOnClickListener {
            viewModel.addScore("B", 1)
        }

        binding.teamBPlusTwoButton.setOnClickListener {
            viewModel.addScore("B", 2)
        }

        binding.teamBPlusThreeButton.setOnClickListener {
            viewModel.addScore("B", 3)
        }

        binding.resetButton.setOnClickListener {
            viewModel.resetScore()
        }
    }
}
