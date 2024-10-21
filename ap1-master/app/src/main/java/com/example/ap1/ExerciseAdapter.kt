import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ap1.R
import com.example.ap1.data.Exercises

class ExercisesAdapter(
    private val exercises: List<Exercises>,
    private val onItemClick: (Exercises) -> Unit // Callback for item click
) : RecyclerView.Adapter<ExercisesAdapter.ExerciseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exercises[position]
        holder.bind(exercise, onItemClick)
    }

    override fun getItemCount() = exercises.size

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvExerciseName: TextView = itemView.findViewById(R.id.tvExerciseName)

        fun bind(exercise: Exercises, onItemClick: (Exercises) -> Unit) {
            tvExerciseName.text = exercise.exerciseName
            itemView.setOnClickListener { onItemClick(exercise) }
        }
    }
}
