package com.donaboyev.scorekeeperappandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textScoreTeam1: TextView? = null
    private var textScoreTeam2: TextView? = null
    private var textFoulTeam1: TextView? = null
    private var textFoulTeam2: TextView? = null
    private var foulsTeam1 = 0
    private var foulsTeam2 = 0
    private var scoreTeam1 = 0
    private var scoreTeam2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadViews()
    }

    private fun loadViews() {
        textScoreTeam1 = findViewById(R.id.text_score1)
        textScoreTeam2 = findViewById(R.id.text_score2)
        textFoulTeam1 = findViewById(R.id.text_foul1)
        textFoulTeam2 = findViewById(R.id.text_foul2)

        val buttonAddFoulTeam1: Button = findViewById(R.id.button_add_foul1)
        val buttonAddFoulTeam2: Button = findViewById(R.id.button_add_foul2)
        val buttonAddScore1Team1: Button = findViewById(R.id.button_add1_team1)
        val buttonAddScore2Team1: Button = findViewById(R.id.button_add2_team1)
        val buttonAddScore3Team1: Button = findViewById(R.id.button_add3_team1)
        val buttonAddScore1Team2: Button = findViewById(R.id.button_add1_team2)
        val buttonAddScore2Team2: Button = findViewById(R.id.button_add2_team2)
        val buttonAddScore3Team2: Button = findViewById(R.id.button_add3_team2)
        val buttonReset: Button = findViewById(R.id.reset_button)

        buttonAddFoulTeam1.setOnClickListener {
            addFoul(Team.First)
        }
        buttonAddFoulTeam2.setOnClickListener {
            addFoul(Team.Second)
        }

        buttonAddScore1Team1.setOnClickListener {
            addScore(Team.First, 1)
        }
        buttonAddScore2Team1.setOnClickListener {
            addScore(Team.First, 2)
        }
        buttonAddScore3Team1.setOnClickListener {
            addScore(Team.First, 3)
        }
        buttonAddScore1Team2.setOnClickListener {
            addScore(Team.Second, 1)
        }
        buttonAddScore2Team2.setOnClickListener {
            addScore(Team.Second, 2)
        }
        buttonAddScore3Team2.setOnClickListener {
            addScore(Team.Second, 3)
        }
        buttonReset.setOnClickListener {
            reset()
        }
    }

    private fun reset() {
        foulsTeam1 = 0
        foulsTeam2 = 0
        scoreTeam1 = 0
        scoreTeam2 = 0
        textFoulTeam1?.text = "$foulsTeam1"
        textFoulTeam2?.text = "$foulsTeam2"
        textScoreTeam1?.text = "$scoreTeam1"
        textScoreTeam2?.text = "$scoreTeam2"
    }

    private fun addScore(team: Team, score: Int) {
        when (team) {
            Team.First -> {
                scoreTeam1 += score
                textScoreTeam1?.text = "$scoreTeam1"
            }

            Team.Second -> {
                scoreTeam2 += score
                textScoreTeam2?.text = "$scoreTeam2"
            }
        }
    }

    private fun addFoul(team: Team) {
        when (team) {
            Team.First -> {
                foulsTeam1++
                textFoulTeam1?.text = "$foulsTeam1"
            }

            Team.Second -> {
                foulsTeam2++
                textFoulTeam2?.text = "$foulsTeam2"
            }
        }
    }
}

enum class Team {
    First, Second
}