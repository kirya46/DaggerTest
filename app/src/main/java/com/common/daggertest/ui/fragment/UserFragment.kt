package com.common.daggertest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.daggertest.R
import com.common.daggertest.entity.User
import com.common.daggertest.mvp.MainContract
import com.common.daggertest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

/**
 * Created by Kirill Stoianov on 21/07/18.
 */
class UserFragment : BaseFragment() {

    companion object {
        val TAG: String = UserFragment::class.java.simpleName

        fun newInstance(user: User): UserFragment {
            val arguments = Bundle()
            arguments.putSerializable("user", user)
            val fragment = UserFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    private lateinit var mUser: User

    @Inject lateinit var router: MainContract.Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { mUser = it.getSerializable("user") as User }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvContent.text = "User fetched \nID: ${mUser.id} \nLast sync: ${appPreferences.getLastSync()}"

        btnDetails.setOnClickListener { router.openUserDetailsScreen(mUser) }
    }

}