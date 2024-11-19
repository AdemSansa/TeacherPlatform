    package tn.rnu.isetr.tp;

    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.PopupMenu;
    import android.widget.RadioGroup;
    import android.widget.Spinner;
    import android.widget.TextView;

    import androidx.fragment.app.Fragment;
    import androidx.lifecycle.ViewModelProvider;
    import androidx.recyclerview.widget.LinearLayoutManager;

    import java.util.ArrayList;
    import java.util.List;

    public class courFragment extends Fragment {
        private EditText Name, Hours;
        private RadioGroup Type;
        private Spinner teacherSpinner;
        private Button addCourseButton;
        private SharedViewModel sharedViewModel;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
            ArrayList <String>teacherList = sharedViewModel.getTeacherNames();
            View view = inflater.inflate(R.layout.fragment_cour, container, false);
            Name = view.findViewById(R.id.name);
            Hours = view.findViewById(R.id.hours);
            Type = view.findViewById(R.id.radio_group_type);
            teacherSpinner = view.findViewById(R.id.spinner_teach);
             addCourseButton = view.findViewById(R.id.button_add_course);
             teacherSpinner.setAdapter( new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, teacherList));

            List<Teacher> teachers = new ArrayList<>();
            if (getArguments() != null) {
                teachers = (List<Teacher>) getArguments().getSerializable("teachers");
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, teacherList);


            return view;
        }
    }
