import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        holder.exerciseImage.setImageResource(getImageResIdForExercise(exercise.exerciseName))
    }

    override fun getItemCount() = exercises.size

    private fun getImageResIdForExercise(exerciseName: String): Int {
        return when (exerciseName.toLowerCase()) {
            "deadlift" -> R.drawable.deadlift
            "plank" -> R.drawable.plank
            "squats" -> R.drawable.squat2
            "push-ups" -> R.drawable.pushup2
            "bench press" -> R.drawable.benchpress
            "burpees" -> R.drawable.burpees
            "mountain climbers" ->R.drawable.mountainclimbers
            // Add more exercise names and corresponding images here
            else -> R.drawable.deadlift// Fallback image if no match is found
        }
    }

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvExerciseName: TextView = itemView.findViewById(R.id.tvExerciseName)
        val exerciseImage: ImageView = itemView.findViewById(R.id.exerciseImage) // Add this to bind the image

        fun bind(exercise: Exercises, onItemClick: (Exercises) -> Unit) {
            tvExerciseName.text = exercise.exerciseName
            itemView.setOnClickListener { onItemClick(exercise) }
        }
    }
}


