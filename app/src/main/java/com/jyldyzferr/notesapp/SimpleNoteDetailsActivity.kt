package com.jyldyzferr.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.jyldyzferr.notesapp.databinding.ActivitySimpleNoteDetailsBinding
import com.jyldyzferr.notesapp.db.Database
import com.jyldyzferr.notesapp.models.Note

class SimpleNoteDetailsActivity : AppCompatActivity() {

    private val binding: ActivitySimpleNoteDetailsBinding by lazy {
        ActivitySimpleNoteDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val note = intent.extras?.getSerializable(NOTE_KEY) as? Note
        initViews(note)


        val database = Database(this)
        binding.saveChangesButton.setOnClickListener{
            database.updateSimpleNote(
                oldNote = note!!,
                title = binding.textviewTitle.text.toString(),
                description = binding.descriptionTextView.text.toString()
            )
        }
    }
    private fun initViews (note: Note?) {
        if (note == null) return


        binding.textviewTitle.text = Editable.Factory.getInstance().newEditable (note.title)
        binding.descriptionTextView.text = Editable.Factory.getInstance().newEditable(note.description)
        binding.lastEditText.text = "Last edited:" + note.lastEditedDate.toString()

        // binding.textviewTitle.text = note.title
     //   binding.descriptionTextView.text = note.description
       // binding.lastEditText.text = "Last edited:" + note.lastEditedDate.toString()
    }
}
