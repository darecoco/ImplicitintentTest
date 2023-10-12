package kr.hs.emirim.darecoco.implicitintenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnCall : Button
    lateinit var btnHome : Button
    lateinit var btnMap : Button
    lateinit var btnSearch : Button
    lateinit var btnSms : Button
    lateinit var btnPicture : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title="암시적 임텐트 연습"

        btnCall = findViewById(R.id.btnCall)
        btnHome = findViewById(R.id.btnHome)
        btnMap = findViewById(R.id.btnMap)
        btnSearch = findViewById(R.id.btnSearch)
        btnSms = findViewById(R.id.btnSms)
        btnPicture = findViewById(R.id.btnPicture)

        btnCall.setOnClickListener{
            var uri = Uri.parse("tel:010-3134-9188") //string을 uri로 바꿔줌
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnHome.setOnClickListener{
            var uri = Uri.parse("https:/m.naver.com") //string을 uri로 바꿔줌
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnMap.setOnClickListener{
            var uri = Uri.parse("https:/maps.google.com/maps?q="+46.0113373+", "+7.7391259) //string을 uri로 바꿔줌
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnSearch.setOnClickListener{
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "흑비양")
            startActivity(intent)
        }
        btnSms.setOnClickListener{
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "흑비양은 귀엽읍니다. The Blacknose Sheep is cute.")
            intent.data = Uri.parse("smsto:" + Uri.encode("010-3134-9188"))
            startActivity(intent)
        }
        btnPicture.setOnClickListener{
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}