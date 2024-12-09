import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ww.space_tubespemogramanmobile.TodoItem
import com.ww.space_tubespemogramanmobile.R



class TodoAdapter(private val items: List<TodoItem>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    // ViewHolder yang menangani referensi elemen-elemen UI dalam setiap item
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        val taskName: TextView = itemView.findViewById(R.id.taskName)
        val taskDate: TextView = itemView.findViewById(R.id.taskDate)
    }

    // Membuat ViewHolder baru dan menghubungkannya dengan layout item_todo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ViewHolder(view)
    }

    // Mengikat data ke dalam ViewHolder yang sesuai
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.checkBox.isChecked = item.isChecked
        holder.taskName.text = item.name
        holder.taskDate.text = item.dueDate

        // Menangani perubahan status checkbox
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
        }
    }

    // Mengembalikan jumlah item dalam data
    override fun getItemCount(): Int {
        return items.size
    }
}
