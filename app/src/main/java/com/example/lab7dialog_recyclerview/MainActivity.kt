package com.example.lab7dialog_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
import layout.Student
import layout.StudentsAdapter

class MainActivity : AppCompatActivity() {
    val studentList:ArrayList<Student> = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentData()
        recycle_view.adapter = StudentsAdapter(this.studentList, applicationContext)
        recycle_view.layoutManager = LinearLayoutManager(applicationContext)
    }
    fun studentData(){
        studentList.add(Student("621234567","Alice",20))
        studentList.add(Student("629876543","Bob",21))
    }
    fun addStudent(view: View){
        val mDialogView:View = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.setView(mDialogView)

        val mAlertDialog:AlertDialog = myBuilder.show()
        mAlertDialog.btnAdd.setOnClickListener(){
            studentList.add(
                Student(
                    mAlertDialog.edt_id.text.toString(),
                    mAlertDialog.edt_name.text.toString(),
                    mAlertDialog.edt_age.text.toString().toInt()
                )
            )
            recycle_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "the student is added successfully",
                Toast.LENGTH_LONG
            ).show()
            mAlertDialog.dismiss()
        }
        mAlertDialog.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }
}