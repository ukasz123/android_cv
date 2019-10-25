package pl.ukaszapps.curricullumvitae.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.ukaszapps.curricullumvitae.R
import pl.ukaszapps.curricullumvitae.view.model.Project

class ExperienceAdapter(inflater: LayoutInflater) : StateAwareAdapter<Project>(inflater) {
    override fun onCreateDataViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      return ProjectViewHolder(inflater.inflate(R.layout.row_project, parent, false))
    }

    override fun onBindDataViewHolder(holder: RecyclerView.ViewHolder, item: Project) {
        (holder as ProjectViewHolder).bind(item)
    }
}

internal class ProjectViewHolder(view: View): RecyclerView.ViewHolder(view), Bindable<Project> {
    private val name = view.findViewById<TextView>(R.id.projectName)
    private val from = view.findViewById<TextView>(R.id.projectDateFrom)
    private val to = view.findViewById<TextView>(R.id.projectDateTo)
    private val company = view.findViewById<TextView>(R.id.projectCompany)
    private val skillsGroup = view.findViewById<ViewGroup>(R.id.projectSkillsUsed)

    override fun bind(value: Project) {
        name.text = value.name
        from.text = value.from
        to.text = value.to ?: to.resources.getText(R.string.date_now)
        company.text = value.company
        skillsGroup.removeAllViews()
        value.skills.forEach {
            skillsGroup.addView(ImageView(skillsGroup.context).apply { setImageResource(it) })
        }
    }

}
