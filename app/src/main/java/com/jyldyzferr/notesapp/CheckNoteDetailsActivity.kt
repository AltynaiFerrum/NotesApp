package com.jyldyzferr.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jyldyzferr.notesapp.databinding.ActivityCheckNoteDetailsBinding
import com.jyldyzferr.notesapp.db.Database
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

        val database = Database(this)
        binding.saveChangesCheckButton.setOnClickListener{
        database.updateCheckNote(
            oldNote = note!!,
            title = binding.titleTextView.text.toString(),
            titles = listOf(
                binding.firstCheckBoxTitle.text.toString(),
                binding.secondCheckBoxTitle.text.toString(),
                binding.thirdCheckBoxTitle.text.toString(),
                binding.fourthCheckBoxTitle.text.toString(),
                binding.fifthCheckBoxTitle.text.toString(),
                binding.sixthCheckBoxTitle.text.toString()
            ),
            isCheckedList = listOf(
                binding.firstCheckBox.isChecked,
                binding.secondCheckBox.isChecked,
                binding.thirdCheckBox.isChecked,
                binding.fourthCheckBox.isChecked,
                binding.fifthCheckBox.isChecked,
                binding.sixthCheckBox.isChecked
            )
        )
        }


            // val note = intent.extras?.getSerializable(NOTE_KEY) as? Note
        //initViews(note)
    }

    private fun initViews(note: Note?) {
        if (note == null) return

        binding.titleTextView.text = null
        binding.titleTextView.setText( note.title)
        binding.lastEditedTextView.text = "Last edited:" + note.lastEditedDate.toString()

        val titles = note.checkBoxTitlesList
        if (titles.isNotEmpty()) {
            binding.firstCheckBoxTitle.text = note.checkBoxTitlesList[0]
        }

        if (titles.isNotEmpty() && titles.size > 1) {
            binding.secondCheckBoxTitle.text = note.checkBoxTitlesList[1]
        }
        if (titles.isNotEmpty() && titles.size > 2) {
            binding.thirdCheckBoxTitle.text = note.checkBoxTitlesList[2]
        }
        if (titles.isNotEmpty() && titles.size > 3) {
            binding.fourthCheckBoxTitle.text = note.checkBoxTitlesList[3]
        }
        if (titles.isNotEmpty() && titles.size > 4) {
            binding.fifthCheckBoxTitle.text = note.checkBoxTitlesList[4]
        }
        if (titles.isNotEmpty() && titles.size > 5) {
            binding.sixthCheckBoxTitle.text = note.checkBoxTitlesList[5]
        }

        val checkedList = note.checkBoxIsCheckedList
        //  if (titles.isNotEmpty()) {
        // binding.firstCheckBoxTitle.setText(note.checkBoxTitlesList[0])
        if (checkedList.isNotEmpty()) {
            binding.firstCheckBox.isChecked = note.checkBoxIsCheckedList[0]
        }

        //  binding.firstCheckBox.isChecked = note.checkBoxIsCheckedList[0]
        if (checkedList.isNotEmpty() && titles.size > 1) {
            binding.secondCheckBox.isChecked = note.checkBoxIsCheckedList[1]
        }
        if (checkedList.isNotEmpty() && titles.size > 2) {
            binding.thirdCheckBox.isChecked = note.checkBoxIsCheckedList[2]
        }

        if (checkedList.isNotEmpty() && titles.size > 3) {
            binding.fourthCheckBox.isChecked = note.checkBoxIsCheckedList[3]
        }

        if (checkedList.isNotEmpty() && titles.size > 4) {
            binding.fifthCheckBox.isChecked = note.checkBoxIsCheckedList[4]
        }
        if (checkedList.isNotEmpty() && titles.size > 5) {
            binding.sixthCheckBox.isChecked = note.checkBoxIsCheckedList[5]
        }
    }
}

