package com.michael.gadsproject;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fragment) {
        super(fragment, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                LearningLeadersFragment leadersFragment = new LearningLeadersFragment();
                return leadersFragment;
            case 1:
                SkillIqLeadersFragment skillIqLeadersFragment = new SkillIqLeadersFragment();
                return skillIqLeadersFragment;
            default:
                return new LearningLeadersFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Learning Leaders";
            case 1:
                return "Skill IQ Leaders";
            default:
                return null;
        }
    }
}
