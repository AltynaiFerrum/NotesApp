package com.jyldyzferr.notesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jyldyzferr.notesapp.databinding.CheckNoteItemBinding
import com.jyldyzferr.notesapp.databinding.SimleNoteItemBinding
import com.jyldyzferr.notesapp.models.Note

class NotesAdapter(
    private val navigateToSimpleDetailsScreen: (note: Note) -> Unit,
    private val navigateToCheckBoxDetailsScreen: (note: Note) -> Unit,

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val notesList = mutableListOf<Note>()

    fun updateList(newList:List<Note>) {
        notesList.clear()
        notesList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class SimpleNoteViewHolder(
        private val binding: SimleNoteItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.title.text = note.title
            binding.descriptionTextView.text = note.description
            binding.lastEditedTextView.text = "Last edited:" + note.lastEditedDate.toString()
            binding.root.setOnClickListener{
                navigateToSimpleDetailsScreen(note)
            }
        }
    }


    inner class CheckNoteViewHolder(
        private val binding: CheckNoteItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.titleTextView.text = note.title
            binding.lastEditedTextView.text = "Last edited:" + note.lastEditedDate.toString()
            binding.root.setOnClickListener{
                navigateToCheckBoxDetailsScreen(note)
            }
            note.checkBoxIsCheckedList.forEachIndexed { index, value ->
                when (index) {
                    0 -> {
                        binding.firstCheckBox.isChecked = value
                        binding.firstCheckBoxTitle.text = note.checkBoxTitlesList[index]
                    }

                    1 -> {
                        binding.secondCheckBox.isChecked = value
                        binding.secondCheckBoxTitle.text = note.checkBoxTitlesList[index]
                    }

                    2 -> {
                        binding.thirdCheckBox.isChecked = value
                        binding.thirdCheckBoxTitle.text = note.checkBoxTitlesList[index]
                    }

                    3 -> {
                        binding.fourthCheckBox.isChecked = value
                        binding.fourthCheckBox.text = note.checkBoxTitlesList[index]
                    }

                    4 -> {
                        binding.fifthCheckBox.isChecked = value
                        binding.fifthCheckBoxTitle.text = note.checkBoxTitlesList[index]
                    }

                    5 -> {
                        binding.sixthCheckBox.isChecked = value
                        binding.sixthCheckBoxTitle.text = note.checkBoxTitlesList[index]
                    }

                }

            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            0 -> {
                val view = inflater.inflate(
                    R.layout.simle_note_item,
                    parent,
                    false
                )
                val binding = SimleNoteItemBinding.bind(view)
                val viewHolder = SimpleNoteViewHolder(binding)
                viewHolder
            }

            else -> {
                val view = inflater.inflate(
                    R.layout.check_note_item,
                    parent,
                    false
                )

                val binding = CheckNoteItemBinding.bind(view)
                val viewHolder = CheckNoteViewHolder(binding)
                viewHolder

            }
        }
    }

    override fun getItemViewType(
        position: Int
    ): Int {
        val note = notesList[position]
        val viewtype = if (note.isSimpleNote) 0 else 1
        return viewtype
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
    if (notesList[position].isSimpleNote){
        (holder as SimpleNoteViewHolder).bind(notesList[position])
    } else {
        (holder as CheckNoteViewHolder).bind(notesList[position])
    }
    }

}