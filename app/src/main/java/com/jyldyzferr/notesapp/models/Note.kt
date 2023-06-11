package com.jyldyzferr.notesapp.models

import android.widget.EditText
import java.io.Serializable
import java.util.Date

data class Note (
    //данные для Simple item note
    val title: String,//общее
    val description: String,
    val lastEditedDate: Date,//общее

    val isSimpleNote: Boolean,

    // Данные для Check box note item

    val checkBoxIsCheckedList: List<Boolean>,
    val checkBoxTitlesList: List<String>
        ):Serializable