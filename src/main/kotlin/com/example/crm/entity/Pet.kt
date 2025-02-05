package com.example.crm.entity

import jakarta.persistence.*

@Entity
@Table(name = "pets")
data class Pet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val species: String,

    @Column
    val breed: String?,

    @Column
    val age: Int?,

    @Column(name = "ownerd_name")
    val ownerdName: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @OneToMany(mappedBy = "pet", cascade = [CascadeType.ALL])
    val vitalSigns: List<VitalSign> = emptyList()
)

