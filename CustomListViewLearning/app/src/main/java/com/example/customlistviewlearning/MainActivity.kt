package com.example.customlistviewlearning

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.customlistviewlearning.databinding.ActivityMainBinding
import com.example.customlistviewlearning.databinding.DialogAddUserBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * This adapter is used by rvUsers
     */
    private var adapter: UserAdapter? = null

    private var users = mutableListOf<User>(
        User(0, "Nguyễn Văn A", 18, true),
        User(1, "Nguyễn Thị B", 17, false),
        User(2, "Hoàng Văn C", 19, true),
        User(3, "Nguyễn Mai D", 20, false),
        User(4, "Nguyễn Văn E", 21, true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Set event add user with dialog fragment
        binding.btnAdd.setOnClickListener {
            DialogAddUser { name, age, male ->
                if (validate(name, age)) {
                    addUser(name, age, male)
                } else {
                    Toast.makeText(
                        this,
                        "Thông tin không hợp lệ!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.show(supportFragmentManager, "DialogFragmentAddUser")
        }

        // Init adapter and submit list for rvUsers
        adapter = UserAdapter()
        binding.rvUsers.adapter = adapter
        adapter?.submitList(users)
    }

    /**
     * This function is used to validate user information
     *
     * @param name
     * @param age
     */
    private fun validate(name: String, age: Byte): Boolean {
        if (name.isEmpty()) return false

        if (age <= 0) return false

        return true
    }

    /**
     * This function is used to add an user to list
     *
     * @param name
     * @param age
     * @param male
     */
    private fun addUser(name: String, age: Byte, male: Boolean) {
        users.add(
            User(users.size, name, age, male)
        )
        Toast.makeText(
            this,
            "Thêm thành công...",
            Toast.LENGTH_SHORT
        ).show()
        adapter?.submitList(users)
    }
}

/**
 * This is dialog fragment which is used to add an user
 *
 * @param onPositiveButtonClick
 */
class DialogAddUser(
    private val onPositiveButtonClick: (String, Byte, Boolean) -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(requireContext())

            val dialogLayout = layoutInflater.inflate(R.layout.dialog_add_user, null)
            val binding = DialogAddUserBinding.bind(dialogLayout)

            builder.setTitle(getString(R.string.txtAddUser))
                .setView(dialogLayout)
                .setPositiveButton(getString(R.string.txtAdd)) { _, _ ->
                    onPositiveButtonClick(
                        binding.edtName.text.toString(),
                        binding.edtAge.text.toString().toByteOrNull() ?: 0,
                        binding.rBtnMale.isChecked
                    )
                }
                .setNegativeButton(getString(R.string.txtCancel)) { _, _ -> }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}