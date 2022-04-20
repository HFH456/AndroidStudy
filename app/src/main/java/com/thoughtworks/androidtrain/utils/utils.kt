package com.thoughtworks.androidtrain.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.thoughtworks.androidtrain.R

public class Utils {

    public fun ReplaceFragmentAndAddToBackStack(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        fragmentId: Int,
        tag: String
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(fragmentId, fragment, tag)
        transaction.addToBackStack(tag)
        transaction.commitAllowingStateLoss()
    }
}