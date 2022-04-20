package com.thoughtworks.androidtrain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.fragment.app.FragmentTransaction
import com.thoughtworks.androidtrain.fragment.fragment1
import com.thoughtworks.androidtrain.fragment.fragment2
import kotlinx.android.synthetic.main.activity_fragment_switch.*

class FragmentChangeActivity : AppCompatActivity(), View.OnClickListener {
    private var fg1: fragment1? = null
    private var fg2: fragment2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_switch)
        btn_change_to1.setOnClickListener(this)
        btn_change_to2.setOnClickListener(this)

        initBlankFragment()
    }

    //显示第一个
    public fun initBlankFragment() {
        //开启事务，fragment的控制是由事务来实现的
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        //add,初始化fragment并添加到事务中，如果为null就new一个
        if (fg1 == null) {
            fg1 = fragment1()
            transaction.add(R.id.content, fg1!!)
        }
        hideFragment(transaction)
//        hideFragment(transaction)
        //方法二：replace，初始化fragment
//        if(f1 == null){
//            f1 = BlankFragment()
//        }
//        transaction.replace(R.id.fragment_container, f1!!)

        //提交事务
        transaction.show(fg1!!)
        transaction.commit()
    }

    //显示第二个
    public fun initFragment2() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (fg2 == null) {
            fg2 = fragment2()
            transaction.add(R.id.content, fg2!!)
        }
        hideFragment(transaction)
        transaction.show(fg2!!)
        transaction.commit()
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        if (fg1 != null) {
            transaction.hide(fg1!!)
        }
        if (fg2 != null) {
            transaction.hide(fg2!!)
        }
    }

    override fun onClick(view: View?) {
        if (view === btn_change_to1) {
            initBlankFragment()
        } else if (view === btn_change_to2) {
            initFragment2()
        }
    }
}