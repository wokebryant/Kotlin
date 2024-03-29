package com.example.kotlindemo.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.FragmentPagerAdapter
import com.example.kotlindemo.adapter.Viewpager2Adapter
import com.example.kotlindemo.databinding.ActivityViewPager2Binding
import com.example.kotlindemo.fragment.HomeFragment
import com.example.kotlindemo.fragment.IndicatorFragment
import com.example.kotlindemo.fragment.PageFragment
import com.example.kotlindemo.study.TAG
import com.example.kotlindemo.utils.binding
import com.example.kotlindemo.widget.pageTransformer.ScaleInTransformer
import com.google.android.material.tabs.TabLayoutMediator
import com.zhaopin.social.appbase.util.curLifecycle
import org.json.JSONArray

/**
 *  ViewPager2示例
 */
class ViewPager2Activity : TransformActivity(), View.OnClickListener {

    private val binding: ActivityViewPager2Binding by binding()

    private lateinit var mViewPager: ViewPager2
    private var mPagerAdapter: Viewpager2Adapter? = null
    private val pageTransformer: CompositePageTransformer
        get()  {
            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(20))
            compositePageTransformer.addTransformer(ScaleInTransformer())
            return compositePageTransformer
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        initViewpager()
        initFragmentPager()

        val list = listOf(1, 2, 3)
        val array = JSONArray(list)
        println(array)
    }

    private fun initViewpager() {
        mPagerAdapter = Viewpager2Adapter(getDataList())

        mViewPager = binding.viewPager
        binding.dragBtn.setOnClickListener(this)
        mViewPager.apply {
            //设置滑动方向
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = mPagerAdapter
            //是否禁止滑动
            isUserInputEnabled = true
            //设置左右两边预加载页面个数
            offscreenPageLimit = 1
            //设置一屏多页
            val recyclerView = getChildAt(0) as RecyclerView
            Log.i(TAG, " childAt= ${recyclerView.toString()}, $childCount")
            recyclerView.apply {
                val padding = 40
                setPadding(padding, 0, padding, 0)
                clipToPadding = false
            }
            //设置页面效果
            setPageTransformer(pageTransformer)
            registerOnPageChangeCallback(onPageChangeCallBack)
        }

        fakeDragBy()
    }

    private fun initFragmentPager() {
        binding.viewPagerFragment.adapter = FragmentPagerAdapter(this)
        binding.viewPagerFragment.offscreenPageLimit = 3
        binding.viewPagerFragment.isUserInputEnabled = true

        TabLayoutMediator(binding.tableLayout, binding.viewPagerFragment) {tab, position ->
            tab.text = position.toString()
        }.attach()
    }

    private fun getDataList(): ArrayList<Int> {
        val dataList = arrayListOf<Int>(1, 2, 3, 4)
        return dataList
    }

    /**
     *  模拟用户滑动
     */
    private fun fakeDragBy() {
        mViewPager.beginFakeDrag()
        if (mViewPager.fakeDragBy(-310f)) {
            mViewPager.endFakeDrag()
        }
    }

    private val onPageChangeCallBack = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
//            Toast.makeText(this@ViewPager2Activity, " 第 $position 页被选中", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.dragBtn.id -> {
                fakeDragBy()
            }
        }
    }

    /**
     * 错误示例
     */
    fun errorUse() {
        // 1. 创建列表存放Fragment
        val fragmentList = mutableListOf(
            HomeFragment(),
            PageFragment(),
            IndicatorFragment()
        )
        //2. 构建FragmentStateAdapter
        binding.viewPagerFragment.adapter = object : FragmentStateAdapter(this@ViewPager2Activity) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }
        }
    }


    /**
     * Google推荐
     */
    inner class InfoAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return INFO_PAGES.size
        }

        override fun createFragment(position: Int): Fragment {
            return INFO_PAGES[position].invoke()
        }

    }

    private val INFO_PAGES = arrayOf(
        { HomeFragment() },
        { PageFragment() },
        { IndicatorFragment() }
    )

}