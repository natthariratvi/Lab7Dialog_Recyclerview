package layout
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.std_item_layout.view.*

class Viewholder(view: View):RecyclerView.ViewHolder(view) {
    val tvID:TextView = view.tv_id
    val tvName:TextView = view.tv_name
    val tvAge:TextView = view.tv_age
}