package com.example.fxreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fxreport.Adapter.CommentAdapter

import com.example.fxreport.Model.Comment
import com.example.fxreport.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_account_settings.*
import kotlinx.android.synthetic.main.activity_comments.*

class CommentsActivity : AppCompatActivity() {
    private  var  postId =""
    private  var  publisherId =""
    private  var firebaseUser : FirebaseUser? = null
    private  var commentAdapter : CommentAdapter? =  null
    private  var commentList : MutableList<com.example.fxreport.Model.Comment>? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)


        val intent = intent
        postId = intent.getStringExtra("postId").toString()
        publisherId = intent.getStringExtra("publishId").toString()

        firebaseUser = FirebaseAuth.getInstance().currentUser


        var recyclerView : RecyclerView
        recyclerView = findViewById(R.id.recycle_view_comments)
        val linerLayoutManager = LinearLayoutManager(this)
        linerLayoutManager.reverseLayout = true
        recyclerView.layoutManager = linerLayoutManager

        commentList = ArrayList()
        commentAdapter = CommentAdapter(this,commentList)
        recyclerView.adapter = commentAdapter



        userInfo()

        readComments()

        getPostImage()

       post_comment.setOnClickListener(View.OnClickListener {
           if (add_comment!!.toString() == "")
           {
                 Toast.makeText(this@CommentsActivity, "comment",Toast.LENGTH_LONG).show()
           }
           else
           {
               addComment()
           }
       })


    }

    private fun addComment() {
        val commentRef = FirebaseDatabase.getInstance().reference
            .child("Comments").child(postId!!)

        val commentsMap = HashMap<String,Any>()
        commentsMap["comment"] = add_comment!!.text.toString()
        commentsMap["publisher"] = firebaseUser!!.uid

        commentRef.push().setValue(commentsMap)

        add_comment!!.text.clear()


    }

    private  fun userInfo()
    {

        val usersRef = FirebaseDatabase.getInstance().getReference()
            .child("Users").child(firebaseUser!!.uid)

        usersRef.addValueEventListener(object  : ValueEventListener
        {


            override fun onDataChange(p0: DataSnapshot)
            {


                if (p0.exists())
                {
                    val user = p0.getValue<User>(User::class.java)

                    Picasso.get().load(user!!.getImage()).placeholder(R.drawable.profile).into(profile_image_comment)

                }


            }

            override fun onCancelled(p0: DatabaseError)

            {

            }
        })
    }

    private  fun getPostImage()
    {

        val postRef = FirebaseDatabase.getInstance().reference
            .child("Post").child(postId!!).child("postimage")

        postRef.addValueEventListener(object  : ValueEventListener
        {


            override fun onDataChange(p0: DataSnapshot)
            {


                if (p0.exists())
                {
                    val image = p0.value.toString()

                    Picasso.get().load(image).placeholder(R.drawable.profile).into(post_image_comment)

                }


            }

            override fun onCancelled(p0: DatabaseError)

            {

            }
        })
    }

    private  fun readComments()
    {
        val commentsRef = FirebaseDatabase.getInstance().reference
            .child("Comments")
            .child(postId)

        commentsRef.addValueEventListener(object  : ValueEventListener{

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists())
                {
                    commentList!!.clear()

                    for (snapshot in p0.children)
                    {
                        val comment = snapshot.getValue(com.example.fxreport.Model.Comment::class.java)
                        commentList!!.add(comment!!)
                    }
                    commentAdapter!!.notifyDataSetChanged()


                }
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
}