package com.example.bottomnavigationtests.ui.dashboard

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigationtests.R
import com.example.bottomnavigationtests.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val binding: FragmentDashboardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard, container, false)
        binding.dashboardViewModel = dashboardViewModel

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.main_menu_categories).setVisible(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.main_menu_categories -> {
            createPopupMenu(item)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun createPopupMenu(item: MenuItem) {
        PopupMenu(context, activity?.findViewById(R.id.main_menu_categories)).apply {
            setOnMenuItemClickListener {
                Toast.makeText(context, "You clicked on: ${it.title}", Toast.LENGTH_SHORT).show()
                true
            }
            menu.add("Option 1")
            menu.add("Option 2")
            show()
        }
    }
}