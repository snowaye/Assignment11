package com.padc.batch9.assignment11.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.View.GONE
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment11.R
import com.padc.batch9.assignment11.adapter.PhotoListAdapter
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.mvp.presenter.PhotoListPresenter
import com.padc.batch9.assignment11.mvp.view.PhotoListView
import com.padc.batch9.assignment11.util.Utils
import com.padc.padckotlin.activities.BaseActivity
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity(), PhotoListView {
    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = GONE
    }

    override fun displaySearchResult(lis: List<PhotoListVo>) {
        Log.i("MainActivity", "displaySearchResult==>"+lis.size)
        mAdapter.clearData()
        mAdapter.setNewData(lis.toMutableList())
        //mAdapter.notifyDataSetChanged()
    }

    override fun displayPhotoList(list: List<PhotoListVo>) {
        //Log.i("MainActivity", "list==>"+list)
        mAdapter.setNewData(list.toMutableList())
    }

    override fun displayError(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToDetail(vo: PhotoListVo) {
        val intent = DetailActivity.newIntent(this, vo.id)
        startActivity(intent)
    }

    private lateinit var mPresenter: PhotoListPresenter

    private  lateinit var mAdapter:PhotoListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utils.setStatusBarColor(this, R.color.colorPrimary)
        mPresenter = ViewModelProviders.of(this).get(PhotoListPresenter::class.java)
        mPresenter.initPresenter(this)
        mAdapter = PhotoListAdapter(mPresenter)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerview.adapter = mAdapter



        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(str: Editable?) {
                str?.let {
                    if (it.length>5) {
                        mPresenter.onEditTextChange(it.toString(), this@MainActivity)
                    }
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })



        mPresenter.onUIReady(this)
    }





}
