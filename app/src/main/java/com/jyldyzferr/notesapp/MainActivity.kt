package com.jyldyzferr.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.core.view.isVisible
import com.jyldyzferr.notesapp.databinding.ActivityMainBinding
import com.jyldyzferr.notesapp.db.Database
import com.jyldyzferr.notesapp.models.Note
import java.util.Date

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val database by lazy {
        Database(this)
    }

    private val allNotesList by lazy {
        Database(this).getAllNotes().toMutableList()
    }

    private val adapter = NotesAdapter(
        navigateToCheckBoxDetailsScreen = ::navigateToCheckBoxDetailsScreen,
        navigateToSimpleDetailsScreen = ::navigateToSimpleDetailsScreen
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.searchView.setOnQueryTextListener(this)
        adapter.updateList(allNotesList)

        binding.mainFloatingAction.setOnClickListener{
            binding.checkboxFloatingActionButton.isVisible = !binding.checkboxFloatingActionButton.isVisible
            binding.simpleFloatingActionButton.isVisible = !binding.simpleFloatingActionButton.isVisible
        }

        Log.i("AndroidAcademy", "allNotesList size = ${allNotesList.size}")
        adapter.updateList(allNotesList)
        binding.simpleFloatingActionButton.setOnClickListener {
            handleActionButtonsClick(
                isSimpleNote = true,
                allNotesList = allNotesList

            )
        }

        binding.checkboxFloatingActionButton.setOnClickListener {
            handleActionButtonsClick(
                isSimpleNote = false,
                allNotesList = allNotesList
            )
        }

        binding.recyclerView.adapter = adapter

    }

    private fun handleActionButtonsClick(
        isSimpleNote: Boolean,
        allNotesList: MutableList<Note>,
    ) {
        val note = database.saveNewNote(isSimpleNote = isSimpleNote)
        allNotesList.add(note)
        adapter.updateList(allNotesList)
        if (isSimpleNote) navigateToSimpleDetailsScreen(note)
        else navigateToCheckBoxDetailsScreen(note)
    }


    private fun navigateToCheckBoxDetailsScreen(note: Note) {

        val intent = Intent(this, CheckNoteDetailsActivity::class.java)
        intent.putExtra(NOTE_KEY, note)
        startActivity(intent)
    }

    private fun navigateToSimpleDetailsScreen(note: Note) {

        val intent = Intent(this, SimpleNoteDetailsActivity::class.java)
        intent.putExtra(NOTE_KEY, note)
        startActivity(intent)

    }

    override fun onQueryTextSubmit(
        query: String?
    ): Boolean {
        Log.i("AndroidAcademy", "query=$query")
        val searchString = query ?: return false
        startSearch(searchString)
        return false
    }

    override fun onQueryTextChange(
        query: String?
    ): Boolean {
        Log.i("AndroidAcademy", "query=$query")
        val searchString = query ?: return false
        startSearch(searchString)
        return false

    }

    private fun startSearch(
        query: String
    ) {
        if (query.isBlank()) {
            adapter.updateList(allNotesList)
            return
        }

        val sortedNoteList = allNotesList.filter {note: Note ->
            note.title.contains(query, ignoreCase = true)
        }

        adapter.updateList(sortedNoteList)

    }
}


const val NOTE_KEY = "NOTE KEY"
