package com.jyldyzferr.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jyldyzferr.notesapp.databinding.ActivityCheckNoteDetailsBinding
import com.jyldyzferr.notesapp.databinding.ActivitySimpleNoteDetailsBinding
import com.jyldyzferr.notesapp.models.Note

class CheckNoteDetailsActivity : AppCompatActivity() {

    private val binding: ActivityCheckNoteDetailsBinding by lazy {
        ActivityCheckNoteDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val note = intent.extras?.getSerializable(NOTE_KEY) as? Note
        initViews(note)
        val check = mutableListOf<String>()
        if (check.isNotEmpty()) {
            val d = check[0]
        }

        if (check.isNotEmpty() && check.size > 0) {
            val d = check[1]
        }
        if (check.isNotEmpty() && check.size > 1) {
            val d = check[2]
        }
        if (check.isNotEmpty() && check.size > 2) {
            val d = check[3]
        }
        if (check.isNotEmpty() && check.size > 3) {
            val d = check[4]
        }
        if (check.isNotEmpty() && check.size > 4) {
            val d = check[5]
        }


    }
    private fun initViews(note: Note?) {
        if (note == null) return
        binding.titleTextView.text = note.title
        binding.lastEditedTextView.text = "Last edited:" + note.lastEditedDate.toString()
        binding.firstCheckBox.isChecked = true
        binding.firstCheckBoxTitle.text = note.checkBoxTitlesList[0]
        binding.secondCheckBox.isChecked = true
        binding.secondCheckBoxTitle.text = note.checkBoxTitlesList[1]
        binding.thirdCheckBox.isChecked = false
        binding.thirdCheckBoxTitle.text = note.checkBoxTitlesList[2]
        binding.fourthCheckBox.isChecked = false
        binding.fourthCheckBox.text = note.checkBoxTitlesList[3]
        binding.fifthCheckBox.isChecked = false
        binding.fifthCheckBoxTitle.text = note.checkBoxTitlesList[4]
        binding.sixthCheckBox.isChecked = false
        binding.sixthCheckBoxTitle.text = note.checkBoxTitlesList[5]

    }
}

