package com.project.dapurly.component

import android.content.Context
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class EdtTextUser : AppCompatEditText {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        // Limit the input to 20 characters
        filters = arrayOf(InputFilter.LengthFilter(20))

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Called to notify you that characters within `s` are about to be replaced with new text
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Called to notify you that somewhere within `s`, the characters `before` in length
                // are about to be replaced with new text with length `count`
            }

            override fun afterTextChanged(s: android.text.Editable) {
                // Called to notify you that somewhere within `s`, the characters have been changed
            }
        })
    }
}
