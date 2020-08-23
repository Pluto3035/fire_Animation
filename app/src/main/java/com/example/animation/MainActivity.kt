package com.example.animation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var frameAnim:AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //添加点击事件
        animationView.setOnClickListener{
           if(frameAnim.isRunning){
               frameAnim.stop()
           }else{
               frameAnim.start()
           }
        }
    }

    override fun onStart() {
        super.onStart()
        //找到imageView 对应的src的drawable 资源  AnimationDrawable
        //启动图片的动画
        //  (animationView.drawable as AnimationDrawable).start()
        manulFireAnim()
    }

    //代码创建火焰燃烧的动画
    //R.drawable.campfire01 获取图片对应的id
    //getDrawable(id)  获取图片对应的图片资源
    fun manulFireAnim() {
        val fires = arrayOf(
            R.drawable.campfire01, R.drawable.campfire02,
            R.drawable.campfire03, R.drawable.campfire04,
            R.drawable.campfire05, R.drawable.campfire06,
            R.drawable.campfire07, R.drawable.campfire08,
            R.drawable.campfire09, R.drawable.campfire10,
            R.drawable.campfire11, R.drawable.campfire12,
            R.drawable.campfire13, R.drawable.campfire14,
            R.drawable.campfire15, R.drawable.campfire16,
            R.drawable.campfire17
        )
         frameAnim=    AnimationDrawable().apply {
            //添加每一帧对应的资源和时间
            for (item in fires) {
                addFrame(getDrawable(item)!!, 100)
            }
            //关联帧动画和图片
            animationView.setImageDrawable(this)
            //启动动画
            start()
        }
    }
}
