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
    }
    private fun initViews(note: Note?) {
        if (note == null) return
        binding.titleTextView.text = note.title
        binding.lastEditedTextView.text = "Last edited:" + note.lastEditedDate.toString()
        binding.firstCheckBox.isChecked = note.checkBoxIsCheckedList[0]
        binding.firstCheckBoxTitle.text = note.checkBoxTitlesList[0]
        binding.secondCheckBox.isChecked = note.checkBoxIsCheckedList[1]
        binding.secondCheckBoxTitle.text = note.checkBoxTitlesList[1]
        binding.thirdCheckBox.isChecked = note.checkBoxIsCheckedList[2]
        binding.thirdCheckBoxTitle.text = note.checkBoxTitlesList[2]
        binding.fourthCheckBox.isChecked = note.checkBoxIsCheckedList[3]
        binding.fourthCheckBox.text = note.checkBoxTitlesList[3]
        binding.fifthCheckBox.isChecked = note.checkBoxIsCheckedList[4]
        binding.fifthCheckBoxTitle.text = note.checkBoxTitlesList[4]
        binding.sixthCheckBox.isChecked = note.checkBoxIsCheckedList[5]
        binding.sixthCheckBoxTitle.text = note.checkBoxTitlesList[5]
    }
}

