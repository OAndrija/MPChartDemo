package com.example.mpchartdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mpchartdemo.databinding.ActivityMainBinding
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BubbleData
import com.github.mikephil.charting.data.BubbleDataSet
import com.github.mikephil.charting.data.BubbleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupBarChart()
        setupPieChart()
        setupLineChart()
        setupBubbleChart()
        setupRadarChart()
    }

    private fun setupBarChart() {
        val entries = listOf(
            BarEntry(1f, 10f),
            BarEntry(2f, 20f),
            BarEntry(3f, 15f),
            BarEntry(4f, 25f),
            BarEntry(5f, 18f)
        )

        val dataSet = BarDataSet(entries, "Bar Chart").apply {
            colors = listOf(
                resources.getColor(android.R.color.holo_blue_light, theme),
                resources.getColor(android.R.color.holo_green_light, theme),
                resources.getColor(android.R.color.holo_red_light, theme),
                resources.getColor(android.R.color.holo_orange_light, theme),
                resources.getColor(android.R.color.holo_purple, theme)
            )
        }

        val barData = BarData(dataSet).apply {
            barWidth = 0.7f
        }

        binding.barChart.apply {
            data = barData
            description.isEnabled = false
            animateY(1000)
        }
    }

    private fun setupPieChart() {
        val entries = listOf(
            PieEntry(30f, "A"),
            PieEntry(50f, "B"),
            PieEntry(20f, "C")
        )

        val dataSet = PieDataSet(entries, "Pie Chart")
        dataSet.colors = listOf(
            resources.getColor(android.R.color.holo_red_light, theme),
            resources.getColor(android.R.color.holo_green_light, theme),
            resources.getColor(android.R.color.holo_blue_light, theme)
        )

        binding.pieChart.data = PieData(dataSet)
        binding.pieChart.description.isEnabled = false
        binding.pieChart.animateY(1000)
    }

    private fun setupLineChart() {
        val entries = listOf(
            Entry(1f, 5f),
            Entry(2f, 10f),
            Entry(3f, 15f),
            Entry(4f, 20f),
            Entry(5f, 18f)
        )

        val dataSet = LineDataSet(entries, "Line Chart").apply {
            color = resources.getColor(android.R.color.holo_purple, theme)
            lineWidth = 2f
            circleRadius = 4f
            setDrawCircles(true)
            setDrawValues(false)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            setDrawFilled(true)
            fillDrawable = resources.getDrawable(R.drawable.gradient_line_fill, theme)
        }

        val lineData = LineData(dataSet)

        binding.lineChart.apply {
            data = lineData
            description.isEnabled = false
            animateX(1000)
        }
    }

    private fun setupBubbleChart() {
        val entries = mutableListOf<BubbleEntry>()

        for (x in 1..10) {
            entries.add(BubbleEntry(x.toFloat(), 10f, (1..3).random().toFloat()))
            entries.add(BubbleEntry(x.toFloat(), 20f, (1..3).random().toFloat()))
            entries.add(BubbleEntry(x.toFloat(), 30f, (1..3).random().toFloat()))
        }

        val dataSet = BubbleDataSet(entries, "Bubble Chart").apply {
            setColors(
                android.graphics.Color.argb(128, 255, 165, 0),
                android.graphics.Color.argb(128, 0, 191, 255)
            )
            valueTextSize = 10f
        }

        val bubbleData = BubbleData(dataSet)

        binding.bubbleChart.apply {
            data = bubbleData
            description.isEnabled = false
            animateY(1000)
            setTouchEnabled(true)
            setScaleEnabled(false)
        }
    }

    private fun setupRadarChart() {
        val entries1 = listOf(
            RadarEntry(2f),
            RadarEntry(3f),
            RadarEntry(5f),
            RadarEntry(4f),
            RadarEntry(1f)
        )

        val entries2 = listOf(
            RadarEntry(3f),
            RadarEntry(2f),
            RadarEntry(4f),
            RadarEntry(5f),
            RadarEntry(2.5f)
        )

        val dataSet1 = RadarDataSet(entries1, "Data Set 1").apply {
            color = resources.getColor(android.R.color.holo_blue_dark, theme)
            fillColor = resources.getColor(android.R.color.holo_blue_light, theme)
            setDrawFilled(true)
        }

        val dataSet2 = RadarDataSet(entries2, "Data Set 2").apply {
            color = resources.getColor(android.R.color.holo_red_dark, theme)
            fillColor = resources.getColor(android.R.color.holo_red_light, theme)
            setDrawFilled(true)
        }

        val radarData = RadarData(dataSet1, dataSet2)

        binding.radarChart.apply {
            data = radarData
            description.isEnabled = false
            animateXY(1000, 1000)
        }
    }
}