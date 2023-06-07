package com.jyldyzferr.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jyldyzferr.notesapp.databinding.ActivitySimpleNoteDetailsBinding
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
    }

    private fun initViews (note: Note?) {
        if (note == null) return
        binding.textviewTitle.text = note.title
        binding.descriptionTextView.text = note.description
        binding.lastEditText.text = "Last edited:" + note.lastEditedDate.toString()
    }
}
