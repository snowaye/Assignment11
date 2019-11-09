package com.padc.batch9.assignment11.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.api.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment11.R
import com.padc.batch9.assignment11.adapter.PhotoDetailAdapter
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.mvp.presenter.DetailPresenter
import com.padc.batch9.assignment11.mvp.view.PhotoDetailView
import com.padc.batch9.assignment11.util.IE_ID
import com.padc.batch9.assignment11.util.Utils
import com.padc.padckotlin.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : BaseActivity(), PhotoDetailView {

    companion object {
        fun newIntent(context: Context, id:String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(IE_ID, id)
            return intent
        }
    }
    override fun displayUserInfo(detail:PhotoListVo) {
        imgv_photo.load(detail.user.profileImage.large) {
            crossfade(true)
            crossfade(2000)
        }
        tvOwnerName.text = detail.user.username
        tvLocation.text = detail.user.name
        imageProfile.load(detail.user.profileImage.small) {
            crossfade(true)
            crossfade(2000)
        }

    }

    override fun displayDetailPhotoLisst(list: List<PhotoDetailVo>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun displayError(message: String) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateBack() {
        finish()
    }


    private lateinit var mAdapter: PhotoDetailAdapter
    private lateinit var bottomView: LinearLayout
    private lateinit var imageProfile: AppCompatImageView
    private lateinit var tvOwnerName: AppCompatTextView
    private lateinit var tvLocation: AppCompatTextView
    private lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getStringExtra(IE_ID)
        Utils.setStatusBarColor(this, R.color.colorPrimary)
        mPresenter = ViewModelProviders.of(this).get(DetailPresenter::class.java)
        mPresenter.initPresenter(this)
        mAdapter = PhotoDetailAdapter()

        bottomView = findViewById(R.id.bottom_sheet)
        imageProfile = bottomView.findViewById(R.id.imgv_owner)
        tvOwnerName = bottomView.findViewById(R.id.tv_owner_name)
        tvLocation = bottomView.findViewById(R.id.tv_channel)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomView)

// change the state of the bottom sheet

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)

        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {


            }

            override fun onStateChanged(p0: View, p1: Int) {
                when (p1) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }


        })
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerview.adapter = mAdapter

        mPresenter.onUIReady(this, id)

        imgv_back.setOnClickListener { mPresenter.onTapNavigateBackButton() }
    }
}