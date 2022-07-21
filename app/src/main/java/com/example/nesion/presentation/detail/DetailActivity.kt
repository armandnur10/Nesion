package com.example.nesion.presentation.detail
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import com.example.nesion.R
import com.example.nesion.data.response.LazyResponse
import com.example.nesion.databinding.ActivityDetailBinding
import com.example.nesion.databinding.CustomNotificationBinding

class DetailActivity : AppCompatActivity(){

    val CHANNEL_ID = "id01"

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<LazyResponse>(NEWS_DATA) as LazyResponse
        Glide.with(this).load(data.thumb).into(binding.ivImage)
        binding.apply {
            tvTitle.text = data.title
            tvDate.text = data.time
            tvCategory.text = data.tag
            tvDescription.text = data.desc
        }
        createNotificationChannel(CHANNEL_ID, "title", "description")


        val builder = NotificationCompat.Builder( this, CHANNEL_ID)
            .setContentTitle(data.title)
            .setContentText(data.desc)
            .setSmallIcon(R.drawable.ic_notif)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        binding.btnDetail.setOnClickListener{
            with(NotificationManagerCompat.from(this)){
                notify(0, builder.build())
            }
        }
    }

    private fun createNotificationChannel(id: String, name: String, desc: String) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importance : Int = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = desc
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


    companion object{
        const val NEWS_DATA = "0"
    }

}